package decouplinghelloworldinterfaces

trait MessageProvider {
    def getMessage : String
}

trait MessageRenderer {
    def render

    def setMessageProvider(provider : decouplinghelloworldinterfaces.MessageProvider)

    def getMessageProvider : decouplinghelloworldinterfaces.MessageProvider
}

class StandardOutMessageRenderer extends MessageRenderer {

    private var messageProvider : decouplinghelloworldinterfaces.MessageProvider = null

    def setMessageProvider(provider : decouplinghelloworldinterfaces.MessageProvider) = {
        messageProvider = provider
    }

    def getMessageProvider : decouplinghelloworldinterfaces.MessageProvider = {
        messageProvider
    }

    def render = {
        if (messageProvider == null) {
            throw new RuntimeException("You need to set a message provider.")
        }

        println(messageProvider.getMessage)
    }
}

class HelloWorldMessageProvider extends MessageProvider {

    private val message : String = "Hello Dave!"

    def getMessage: String = {
        message
    }
}


object DecouplingHelloWorldInterfaces extends App {
    val mr : decouplinghelloworldinterfaces.MessageRenderer = new decouplinghelloworldinterfaces.StandardOutMessageRenderer
    val mp : decouplinghelloworldinterfaces.MessageProvider = new decouplinghelloworldinterfaces.HelloWorldMessageProvider

    mr.setMessageProvider(mp)
    mr.render
}

