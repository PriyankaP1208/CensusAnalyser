package com.bridgelabz;
import com.opencsv.bean.CsvBindByName;

public class IndianStatesCodeCSV {

    @CsvBindByName(column = "SrNo", required = true)
    public int SrNo;

    @CsvBindByName(column = "State Name", required = true)
    public String state;

    @CsvBindByName(column = "TIN", required = true)
    public int tin;

    @CsvBindByName(column = "StateCode", required = true)
    public String stateCode;

    @Override
    public String toString() {
        return "IndianStatesCodeCSV{" +
                "SrNo='" + SrNo + '\'' +
                ", state=" + state +
                ", tin=" + tin +
                ", stateCode=" + stateCode +
                '}';
    }
}
