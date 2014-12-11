package mx.redhat.fuse.prosa.netty.consumidor;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.apache.camel.dataformat.bindy.annotation.CsvRecord;
import org.apache.camel.dataformat.bindy.annotation.DataField;
import javax.xml.bind.annotation.XmlElement;

@SuppressWarnings("serial")
@CsvRecord(separator = "\\|")
@XmlRootElement(name = "FinancialMessage_REQUEST")
@XmlType(propOrder = {"code", "procesingCode", "transactionAmount", "transmissionDate", "systemTraceAuditNumber", "additionalResponseData", "reserved"})
public class TransformacionXML implements Serializable {

    @DataField(pos = 1)
    private String code;

    @DataField(pos = 2)
    private Integer procesingCode;

    @DataField(pos = 3)
    private Integer transactionAmount;

    @DataField(pos = 4)
    private String transmissionDate;

    @DataField(pos = 5)
    private String systemTraceAuditNumber;

    @DataField(pos = 6)
    private String additionalResponseData;

    @DataField(pos = 7)
    private String reserved;

    @XmlElement(name = "code")
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @XmlElement(name = "procesingCode")
    public Integer getprocesingCode() {
        return procesingCode;
    }

    public void setprocesingCode(Integer procesingCode) {
        this.procesingCode = procesingCode;
    }

    @XmlElement(name = "transactionAmount")
    public Integer gettransactionAmount() {
        return transactionAmount;
    }

    public void settransactionAmount(Integer transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    @XmlElement(name = "transmissionDate")
    public String gettransmissionDate() {
        return transmissionDate;
    }

    public void settransmissionDate(String transmissionDate) {
        this.transmissionDate = transmissionDate;
    }

    @XmlElement(name = "systemTraceAuditNumber")
    public String getsystemTraceAuditNumber() {
        return systemTraceAuditNumber;
    }

    public void setsystemTraceAuditNumber(String systemTraceAuditNumber) {
        this.systemTraceAuditNumber = systemTraceAuditNumber;
    }

    @XmlElement(name = "additionalResponseData")
    public String getadditionalResponseData() {
        return additionalResponseData;
    }

    public void setadditionalResponseData(String additionalResponseData) {
        this.additionalResponseData = additionalResponseData;
    }

    @XmlElement(name = "reserved")
    public String getreserved() {
        return reserved;
    }

    public void setreserved(String reserved) {
        this.reserved = reserved;
    }

    @Override
    public String toString() {
        return "[code=" + code + ", procesingCode=" + procesingCode + ", transactionAmount=" + transactionAmount
                + ", transmissionDate=" + transmissionDate + ", systemTraceAuditNumber=" + systemTraceAuditNumber
                + ", additionalResponseData=" + additionalResponseData + ", reserved=" + reserved + "]";
    }

}
