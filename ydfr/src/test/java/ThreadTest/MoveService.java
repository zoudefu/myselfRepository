package ThreadTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;

public class MoveService {

	LinkedBlockingQueue<Object> queue = new LinkedBlockingQueue<>();

	class Request {
		String moiveCode;// 电影主键
		CompletableFuture<Map<String, Object>> future;// 接受结果
	}

	@PostConstruct // @PostConstruct修饰的方法会在服务器加载Servle的时候运行，并且只会被服务器执行一次。PostConstruct在构造函数之后执行,init()方法之前执行。PreDestroy（）方法在destroy()方法执行执行之后执行
	private void init() {
		ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
		scheduledExecutorService.scheduleAtFixedRate(() -> {
			// 1.取出queue的请求，生成一次批量查询
			int size = queue.size();
			if (size <= 0) {
				return;
			}
			ArrayList<Request> requests = new ArrayList<>();
			for (int i = 0; i < size; i++) {
				requests.add((Request) queue.poll());// 将队列里所有的request 放到一个List里
			}
			// 2.通过每是毫秒积攒的请求批处理后的到的结果resultMapList 伪代码
			List<Map<String, Object>> resultMapList = new ArrayList<>();
			Map<String, Map<String, Object>> responsesMap = new HashMap<>();
			for (Map<String, Object> map : resultMapList) {
				String code = (String) map.get("moiceCode");
				responsesMap.put(code, map);
			}
			// 3.将结果相应 分发给每一个单独的用户请求 定时任务处理线程--》1000个用户的请求
			for (Request request : requests) {
				request.future.complete(responsesMap.get(request.moiveCode));
			}

		}, 0, 10, TimeUnit.MILLISECONDS);// 开始时间是零 每10毫秒 执行一下
	}
	//1000个用户  1000个请求
	public Map<String,Object>  queryMovie(String  movieCode) throws InterruptedException, ExecutionException{
		//1000次的请求 怎样才能变成  更少的接口调用
		//思路 将不同用户的同类请求合并起来
		//并非立刻发起接口调用  请求  收集  再进行
		Request request=new Request();
		request.moiveCode=movieCode;
		CompletableFuture<Map<String, Object>> futuer=new CompletableFuture<>();
		request.future=futuer;
		queue.add(request);
		return futuer.get();
	} 
}
