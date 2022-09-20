import org.openrndr.animatable.Animatable
import org.openrndr.animatable.PropertyAnimationKey

abstract class Chainable : Animatable(){
    var active = false

    var follow:(()->Unit)? = null
    fun chain(f:(()->Unit)?){
        follow = f
    }

    var onhold:Long = 0
    fun hold_for(delay:Long){
        onhold = delay
    }

    fun start(){
        delay(onhold)
        assign()
        active = true
    }

    fun <T> end(a: PropertyAnimationKey<T>){
        active = false
        a.completed.listen{
            if(follow!=null) follow?.invoke()
        }
    }

    abstract fun assign()
}