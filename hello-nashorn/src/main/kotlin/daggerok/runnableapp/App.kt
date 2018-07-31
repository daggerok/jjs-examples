package daggerok.runnableapp

import javax.script.Invocable
import javax.script.ScriptEngineManager

fun main(args: Array<String>) {
    val engine = ScriptEngineManager().getEngineByName("nashorn")
    engine.eval("""
      function greet(name) {
        return "Hello, " + name + "!";
      }
      var greeting = "Ololo-Trololo";
      function run() {
        print("greet('" + greeting + "') = '" + greet(greeting) + "'");
      }
    """)
    val invocable = engine as Invocable
    val runnable = invocable.getInterface(Runnable::class.java)
    runnable.run()
}
