package decoupledhelloworld

class StandardOutMessageRenderer {

    private var messageProvider : HelloWorldMessageProvider = null

    def setMessageProvider(provider : HelloWorldMessageProvider) = {
        messageProvider = provider
    }

    def getMessageProvider : HelloWorldMessageProvider = {
        messageProvider
    }

    def render() = {
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

object DecoupledHelloWorld extends App {
    val mr : StandardOutMessageRenderer = new StandardOutMessageRenderer
    val mp : HelloWorldMessageProvider   = new HelloWorldMessageProvider

    mr.setMessageProvider(mp)
    mr.render()
}