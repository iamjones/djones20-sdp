object HelloWorldCmdArgs {
    def main(args: Array[String]) = {
        Runner.main(Array());
    }
}


object Runner {
    def main(args: Array[String]) = {
        if (args.length > 0) {
            args.foreach(arg => println(arg))
        }
        else {
            println("Hello Dave!")
        }
    }
}
