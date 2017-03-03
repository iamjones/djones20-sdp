package facadepattern

case class ScheduleServerImpl() extends ScheduleServer {

    override def startBooting {
        println("Starting server")
    }

    override def readSystemConfigFile {
        println("Reading system config file")
    }

    override def init {
        println("Initialise Server")
    }

    override def initializeContext {
        println("Initialise Content")
    }

    override def initializeListeners {
        println("Initialise Listeners")
    }

    override def createSystemObjects {
        println("Create system objects")
    }

    override def releaseProcesses {
        println("Release processes")
    }

    override def destory {
        println("Destory server")
    }

    override def destroySystemObjects {
        println("Destory System Objects")
    }

    override def destoryListeners {
        println("Destory Listeners")
    }

    override def destoryContext {
        println("Destory Context")
    }

    override def shutdown {
        println("Shutdown server")
    }
}
