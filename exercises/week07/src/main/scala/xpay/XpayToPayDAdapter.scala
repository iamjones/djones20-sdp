package xpay

class XpayToPayDAdapter(payD: PayD) extends Xpay {

    var cardExpiryYear : String = _

    override def getCreditCardNo: String = {
        payD.getCustCardNo
    }

    override def setCreditCardNo(creditCardNo: String): Unit = {
        payD.setCustCardNo(creditCardNo)
    }

    override def getCustomerName: String = {
        payD.getCardOwnerName
    }

    override def setCustomerName(customerName: String): Unit = {
        payD.setCardOwnerName(customerName)
    }

    override def getCardExpMonth: String = {
        payD.getCardExpMonthDate
    }

    override def setCardExpMonth(cardExpMonth: String): Unit = {
        payD.setCardExpMonthDate(cardExpMonth)
    }

    override def getCardExpYear: String = {
        cardExpiryYear
    }

    override def setCardExpYear(cardExpYear: String): Unit = {
        cardExpiryYear = cardExpYear
    }

    override def getCardCVVNo: Short = {
        val value = payD.getCVVNo

        value.toShort
    }

    override def setCardCVVNo(cardCVVNo: Short): Unit = {
        payD.setCVVNo(cardCVVNo.toInt)
    }

    override def getAmount: Double = {
        payD.getTotalAmount
    }

    override def setAmount(amount: Double): Unit = {
        payD.setTotalAmount(amount)
    }
}
