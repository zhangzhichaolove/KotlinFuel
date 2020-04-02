package com.chao.kotlinfuel

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.github.kittinunf.fuel.core.FuelManager
import com.github.kittinunf.fuel.core.Method
import com.github.kittinunf.fuel.core.Request
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    private val TAG = this.javaClass.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initFuel()
//        content.setOnTouchListener(OnTouchListener { view, motionEvent ->
//            // 解决scrollView中嵌套textView导致其不能上下滑动的问题
//            view.parent.requestDisallowInterceptTouchEvent(true)
//            when (motionEvent.action and MotionEvent.ACTION_MASK) {
//                MotionEvent.ACTION_UP -> view.parent.requestDisallowInterceptTouchEvent(
//                    false
//                )
//            }
//            false
//        })
        content.movementMethod = ScrollingMovementMethod.getInstance();
    }

    private fun initFuel() {
        //val requestInterceptors: MutableList<((Request)-> Request)-> ((Request)->Request)> = mutableListOf()
        //服务器接口地址
        FuelManager.instance.basePath = "https://blog.peakchao.com"
        //超时时间20秒
        FuelManager.instance.timeoutInMillisecond = 20000
        //FuelManager.instance.baseHeaders = mapOf("token" to "BearerAbCdEf123456")
        //添加header拦截器
        FuelManager.instance.addRequestInterceptor(tokenInterceptor())
        //添加请求日志拦截器
        FuelManager.instance.addRequestInterceptor(cUrlLoggingRequestInterceptor())
        //foldRight 是 List 的一个扩展函数 从右往左，对列表中的每一个元素执行 operation 操作，
        // 每个操作的结果是下一次操作的入参，第一次 operation 的初始值是 initial。
        //requestInterceptors.foldRight({r: Request -> r}){f,acc-> f(acc)}
    }


    private fun tokenInterceptor() = { next: (Request) -> Request ->
        { req: Request ->
            //"Content-Type:application/x-www-form-urlencoded; charset=UTF-8"
            req.header(mapOf("token" to "BearerAbCdEf123456"))//变量替换
            next(req)
        }
    }

    private fun cUrlLoggingRequestInterceptor() = { next: (Request) -> Request ->
        { r: Request ->
            var logging = StringBuffer()
            logging.append("\n-----Method = ${r.method}")
            //logging.append("\n-----mediaTypes = ${r.mediaTypes}")
            logging.append("\n-----headers = ${r.headers}")
            logging.append("\n-----url---->${r.url}")
            logging.append("\n-----body---->${r.body}")
            when (r.method) {
                Method.POST -> {
                    logging.append("\n-----request parameters:")
                    r.parameters.forEach {
                        logging.append("\n-----${it.first}=${it.second}")
                    }
                }
            }
            Log.e(TAG, logging.toString())
            next(r)
        }
    }

    fun request(view: View) {
        "/macos升级catalina后环境变量更新.html".httpGetSource().response { request, response, result ->
            println(request)
            println(response)
            val (data, error) = result
            Log.e(TAG, String(data!!))
        }
        "http://web.peakchao.top:250/video/getVideoBanner".httpGet<HttpResult<List<VideoModal>>>(
            { result ->
                runOnUiThread {
                    content.text = result.toString()
                    content.postInvalidate()
                    Log.e(TAG, result.toString())
                }
            },
            error = { message ->
                runOnUiThread {
                    content.text = message
                    content.postInvalidate()
                    Log.e(TAG, message)
                }
            })
//        Fuel.post("https://blog.peakchao.com").body("{ \"name\" : \"peak\" }").response { request, response, result ->
//            val (data, error) = result
//        }
    }
}
