import org.openrndr.application
import org.openrndr.color.ColorRGBa
import org.openrndr.draw.loadFont
import org.openrndr.draw.loadImage
import org.openrndr.draw.tint
import kotlin.math.cos
import kotlin.math.sin
import ChainableAnimation.Chainable
import org.openrndr.animatable.easing.Easing

fun main() = application {
    configure {
        width = 600
        height = 400
    }

    program {
        val ligmaBall = object : Chainable() {
            var x = width/4.0

            override fun assign() { //override the abstract method and Chainable will handle the into and outof
                ::x.animate(-width/4.0, 1000, Easing.QuartInOut)
                ::x.complete()
                delay(300)
                end(//end(::var.animate()) after this animation it will trigger the follow animation
                ::x.animate(width/4.0, 1000, Easing.QuartInOut)
                )
            }
        }

        ligmaBall.chain(ligmaBall::start) //put the function reference of the following animation here
        ligmaBall.hold_for(1400) //delay at the start
        ligmaBall.start() //start the animation
        extend {
            drawer.clear(ColorRGBa.BLACK)

            ligmaBall.updateAnimation()//call every frame? i'm not sure how the basic one works either

            drawer.fill = ColorRGBa.PINK
            drawer.stroke = null
            drawer.circle(width/2.0+ligmaBall.x, height/2.0, 40.0)
        }
    }
}
