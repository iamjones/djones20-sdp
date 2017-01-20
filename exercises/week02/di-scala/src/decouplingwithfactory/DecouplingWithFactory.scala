package decouplingwithfactory

import java.io.FileInputStream
import java.util.Properties

trait MessageProvider {
    def getMessage : String
}

trait MessageRenderer {
    def render

    def setMessageProvider(provider : decouplinghelloworldinterfaces.MessageProvider)

    def getMessageProvider : decouplinghelloworldinterfaces.MessageProvider
}

object MessageSupportFactory {
    private val instance: decouplingwithfactory.MessageSupportFactory = new decouplingwithfactory.MessageSupportFactory

    def getInstance() : decouplingwithfactory.MessageSupportFactory = {
        instance
    }
}

class MessageSupportFactory private() {

    private var props: Properties = _
    private var renderer: MessageRenderer = _
    private var provider: MessageProvider = _

    props = new Properties

    try {

        var propertyPath: String = "di-scala/src/decouplingwithfactory/bean.properties"

        props.load(new FileInputStream(propertyPath))

        val renderClass : String = props.getProperty("renderer.class")
        val providerClass : String = props.getProperty("provider.class")

        renderer = Class.forName(renderClass).newInstance.asInstanceOf[MessageRenderer]
        provider = Class.forName(providerClass).newInstance.asInstanceOf[MessageProvider]
    }
    catch {
        case ex: Exception => {
            System.err.println("Failed to create factory methods");
            ex.printStackTrace()
        }
    }

    def getMessageRenderer : MessageRenderer = renderer
    def getMessageProvider : MessageProvider = provider
}