package hello;

/**
 * Created by ahmadjawid on 5/21/17.
 */

public class PollutionData extends Schema {



    private String stationCode;
    private String stationName;
    private int dailyMean;
    private String measuringMethod;
    private String firstMeasuringDate;
    private String recentMeasuringDate;
    private int jan;
    private int feb;
    private int mar;
    private int apr;
    private int may;
    private int jun;
    private int jul;
    private int aug;
    private int sep;
    private int oct;
    private int nov;
    private int dec;

    public PollutionData() {

    }

    @Override
    public String [] getClassVariableNames(){
        return new String[] { "stationCode", "stationName", "dailyMean", "measuringMethod", "firstMeasuringDate",
                "recentMeasuringDate", "jan", "feb", "mar", "apr", "may", "jun", "jul", "aug", "sep", "oct", "nov", "dec"};
    }

    @Override
    public String getDelimiter() {
        return ";";
    }


    @Override
    public void process() {

        System.out.println(stationName.toUpperCase());
    }

    @Override
    public void preProcess() {
        // TODO remove first lines
    }

    public PollutionData(String stationCode, String stationName, int dailyMean, String measuringMethod, String firstMeasuringDate,
                         String recentMeasuringDate, int jan, int feb, int mar, int apr, int may, int jun, int july, int aug,
                         int sep, int oct, int nov, int dec) {
        this.stationCode = stationCode;
        this.stationName = stationName;
        this.dailyMean = dailyMean;
        this.measuringMethod = measuringMethod;
        this.firstMeasuringDate = firstMeasuringDate;
        this.recentMeasuringDate = recentMeasuringDate;
        this.jan = jan;
        this.feb = feb;
        this.mar = mar;
        this.apr = apr;
        this.may = may;
        this.jun = jun;
        this.jul = july;
        this.aug = aug;
        this.sep = sep;
        this.oct = oct;
        this.nov = nov;
        this.dec = dec;
    }


    public String getStationCode() {
        return stationCode;
    }

    public void setStationCode(String stationCode) {
        this.stationCode = stationCode;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public int getDailyMean() {
        return dailyMean;
    }

    public void setDailyMean(int dailyMean) {
        this.dailyMean = dailyMean;
    }

    public String getMeasuringMethod() {
        return measuringMethod;
    }

    public void setMeasuringMethod(String measuringMethod) {
        this.measuringMethod = measuringMethod;
    }

    public String getFirstMeasuringDate() {
        return firstMeasuringDate;
    }

    public void setFirstMeasuringDate(String firstMeasuringDate) {
        this.firstMeasuringDate = firstMeasuringDate;
    }

    public String getRecentMeasuringDate() {
        return recentMeasuringDate;
    }

    public void setRecentMeasuringDate(String recentMeasuringDate) {
        this.recentMeasuringDate = recentMeasuringDate;
    }

    public int getJan() {
        return jan;
    }

    public void setJan(int jan) {
        this.jan = jan;
    }

    public int getFeb() {
        return feb;
    }

    public void setFeb(int feb) {
        this.feb = feb;
    }

    public int getMar() {
        return mar;
    }

    public void setMar(int mar) {
        this.mar = mar;
    }

    public int getApr() {
        return apr;
    }

    public void setApr(int apr) {
        this.apr = apr;
    }

    public int getMay() {
        return may;
    }

    public void setMay(int may) {
        this.may = may;
    }

    public int getJun() {
        return jun;
    }

    public void setJun(int jun) {
        this.jun = jun;
    }

    public int getJul() {
        return jul;
    }

    public void setJul(int jul) {
        this.jul = jul;
    }

    public int getAug() {
        return aug;
    }

    public void setAug(int aug) {
        this.aug = aug;
    }

    public int getSep() {
        return sep;
    }

    public void setSep(int sep) {
        this.sep = sep;
    }

    public int getOct() {
        return oct;
    }

    public void setOct(int oct) {
        this.oct = oct;
    }

    public int getNov() {
        return nov;
    }

    public void setNov(int nov) {
        this.nov = nov;
    }

    public int getDec() {
        return dec;
    }

    public void setDec(int dec) {
        this.dec = dec;
    }

    @Override
    public String toString() {
        return "PollutionData{" +
                "stationCode='" + stationCode + '\'' +
                ", stationName='" + stationName + '\'' +
                ", dailyMean=" + dailyMean +
                ", measuringMethod='" + measuringMethod + '\'' +
                ", firstMeasuringDate='" + firstMeasuringDate + '\'' +
                ", recentMeasuringDate='" + recentMeasuringDate + '\'' +
                ", jan=" + jan +
                ", feb=" + feb +
                ", mar=" + mar +
                ", apr=" + apr +
                ", may=" + may +
                ", jun=" + jun +
                ", jul=" + jul +
                ", aug=" + aug +
                ", sep=" + sep +
                ", oct=" + oct +
                ", nov=" + nov +
                ", dec=" + dec +
                '}';
    }

}
