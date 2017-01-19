package decouplinghelloworldinterfaces


trait MessageRenderer {
    def render

    def setMessageProvider(provider : decouplinghelloworldinterfaces.HelloWorldMessageProvider)

    def getMessageProvider : decouplinghelloworldinterfaces.HelloWorldMessageProvider
}

class StandardOutMessageRenderer extends MessageRenderer {

    private var messageProvider : decouplinghelloworldinterfaces.HelloWorldMessageProvider = null

    def setMessageProvider(provider : decouplinghelloworldinterfaces.HelloWorldMessageProvider) = {
        messageProvider = provider
    }

    def getMessageProvider : decouplinghelloworldinterfaces.HelloWorldMessageProvider = {
        messageProvider
    }

    def render = {
        if (messageProvider == null) {
            throw new RuntimeException("You need to set a message provider.")
        }

        println(messageProvider.getMessage)
    }
}

class HelloWorldMessageProvider {

    private val message : String = "Hello Dave!"

    def getMessage: String = {
        message
    }
}


object DecouplingHelloWorldInterfaces extends App {
    val mr : decouplinghelloworldinterfaces.StandardOutMessageRenderer = new decouplinghelloworldinterfaces.StandardOutMessageRenderer
    val mp : decouplinghelloworldinterfaces.HelloWorldMessageProvider   = new decouplinghelloworldinterfaces.HelloWorldMessageProvider

    mr.setMessageProvider(mp)
    mr.render
}

