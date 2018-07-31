package daggerok

import javax.script.Invocable
import javax.script.ScriptEngineManager

fun main(args: Array<String>) {
  val engine = ScriptEngineManager().getEngineByName("nashorn")
  engine.eval("""
    function greet(name) {
      return "Hello, " + name + "!";
    }
  """)
  val invocable = engine as Invocable
  println(invocable.invokeFunction("greet", "World"))
  println(invocable.invokeFunction("greet", "Maksimko"))
}
