package hello;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;

/**
 * Created by ahmadjawid on 5/21/17.
 */


/*this class is not used for now*/
public class PlayerFieldSetMapper implements FieldSetMapper<PollutionData> {
    public PollutionData mapFieldSet(FieldSet fieldSet) {
        PollutionData pollutionData = new PollutionData();

        pollutionData.setStationCode(fieldSet.readString(0));
        pollutionData.setStationName(fieldSet.readString(1));
        pollutionData.setDailyMean(fieldSet.readInt(2));
        pollutionData.setMeasuringMethod(fieldSet.readString(3));
        pollutionData.setFirstMeasuringDate(fieldSet.readString(4));
        pollutionData.setRecentMeasuringDate(fieldSet.readString(5));
        pollutionData.setJan(fieldSet.readInt(6));
        pollutionData.setFeb(fieldSet.readInt(7));
        pollutionData.setMar(fieldSet.readInt(8));
        pollutionData.setApr(fieldSet.readInt(9));
        pollutionData.setMay(fieldSet.readInt(10));
        pollutionData.setJun(fieldSet.readInt(11));
        pollutionData.setJul(fieldSet.readInt(12));
        pollutionData.setAug(fieldSet.readInt(13));
        pollutionData.setSep(fieldSet.readInt(14));
        pollutionData.setOct(fieldSet.readInt(15));
        pollutionData.setNov(fieldSet.readInt(16));
        pollutionData.setDec(fieldSet.readInt(17));

        return pollutionData;
    }
}
