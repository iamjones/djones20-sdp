package observer

import scala.collection.mutable.ListBuffer

class CommentaryObject(var subscribers: ListBuffer[Observer], val title: String) extends Subject with Commentary {

    def subscribeObserver(observer: Observer) {
        subscribers += observer
    }

    def unSubscribeObserver(observer: Observer) {
        subscribers -= observer
    }

    def notifyObservers() {
//        subscribers.toList.foreach(x => x.)
    }

    def subjectDetails: String = {
        subscribers.toString()
    }

    def setDesc(desc: String) {
        subscribers.foreach(x => x.update(desc))
    }
}
