package zqx.rj.com.playandroid.account.data.context

import android.app.Activity
import android.content.Context
import android.widget.ImageView
import zqx.rj.com.mvvm.common.Preference
import zqx.rj.com.mvvm.common.constant.Constant
import zqx.rj.com.mvvm.context.UserState

/**
 * author：  HyZhan
 * created： 2018/10/18 9:56
 * desc：    登陆状态管理
 */
class LoginContext private constructor() {

    private val isLogin: Boolean by Preference(Constant.LOGIN_KEY, false)

    // 设置默认状态
    var mState: UserState = if (isLogin) LoginState() else LogoutState()

    companion object {
        val instance = Holder.INSTANCE
    }

    // 内部类 单利
    private object Holder {
        val INSTANCE = LoginContext()
    }

    // 收藏
    fun collect(context: Context?, image: ImageView) {
        mState.collect(context, image)
    }


    fun toCollectActivity(context: Context?) {
        mState.toCollectActivity(context)
    }


    fun login(context: Activity?) {
        mState.login(context)
    }

}