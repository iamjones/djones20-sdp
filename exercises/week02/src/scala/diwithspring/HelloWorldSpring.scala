package scala.diwithspring

import java.io.FileInputStream
import java.util.Properties

import org.springframework.beans.factory.BeanFactory
import org.springframework.beans.factory.support.{DefaultListableBeanFactory, PropertiesBeanDefinitionReader}

trait MessageProvider {
    def getMessage : String
}

trait MessageRenderer {
    def render

    def setMessageProvider(provider : diwithspring.MessageProvider)

    def getMessageProvider : diwithspring.MessageProvider
}

object HelloWorldSpring extends App {

    @throws(classOf[Exception])
    val factory: BeanFactory = getBeanFactory

    val mr: MessageRenderer = factory.getBean("renderer").asInstanceOf[MessageRenderer]
    val mp: MessageProvider = factory.getBean("provider").asInstanceOf[MessageProvider]
    mr.setMessageProvider(mp)
    mr.render

    @throws(classOf[Exception])
    private def getBeanFactory: BeanFactory = {
        val factory: DefaultListableBeanFactory = new DefaultListableBeanFactory
        val definitionReader: PropertiesBeanDefinitionReader = new PropertiesBeanDefinitionReader(factory)

        val propertyPath: String = "/Users/davidjones/Dropbox/github/sdp/exercises/week02/di-scala/src/scala.diwithspring/bean.properties"
        val props: Properties = new Properties

        props.load(new FileInputStream(propertyPath))
        definitionReader.registerBeanDefinitions(props)

        factory
    }
}