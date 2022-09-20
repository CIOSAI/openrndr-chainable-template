[Please check out official doc](https://guide.openrndr.org/animation/interactiveAnimations.html)

Added very easy way to chain animations

## assign()

`override fun assign(){ your animations }`

## end()

after the input animation, it will trigger the chained animation

`end(var::animation(blah, blah, blah))`

## chain()

this input function will be called when the animation ends

`chain(::fun_name)`

## delay()

gives it a bit of delay at the start

`delay(69420)`
