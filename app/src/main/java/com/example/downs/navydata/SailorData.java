package com.example.downs.navydata;

/** SailorData - This is an object class that holds information for each Sailor entered
 * Created by Downs on 2/20/2017.
 */

public class SailorData {
    private long id;
    private String name;
    private String unit;
    private String nosc;
    private String mob_activity;
    private String mob_billet;
    private String truic;
    private String umuic;
    private String nosc_uic;
    private String prd;
    private String eaos;
    private String ced;
    private String report_date;
    private String rank_date;
    private String clearance_date;

    public SailorData() {
        super();
    }

    public SailorData(String name, String unit, String nosc, String mob_activity, String mob_billet,
                      String truic, String umuic, String nosc_uic, String prd, String eaos, String ced,
                      String report_date, String rank_date, String clearance_date
                      ) {
        this.name = name;
        this.unit = unit;
        this.nosc = nosc;
        this.mob_activity = mob_activity;
        this.mob_billet = mob_billet;
        this.truic = truic;
        this.umuic = umuic;
        this.nosc_uic = nosc_uic;
        this.prd = prd;
        this.eaos = eaos;
        this.ced = ced;
        this.report_date = report_date;
        this.rank_date = rank_date;
        this.clearance_date = clearance_date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getNosc() {
        return nosc;
    }

    public void setNosc(String nosc) {
        this.nosc = nosc;
    }

    public String getMob_activity() {
        return mob_activity;
    }

    public void setMob_activity(String mob_activity) {
        this.mob_activity = mob_activity;
    }

    public String getMob_billet() {
        return mob_billet;
    }

    public void setMob_billet(String mob_billet) {
        this.mob_billet = mob_billet;
    }

    public String getTruic() {
        return truic;
    }

    public void setTruic(String truic) {
        this.truic = truic;
    }

    public String getUmuic() {
        return umuic;
    }

    public void setUmuic(String umuic) {
        this.umuic = umuic;
    }

    public String getNosc_uic() {
        return nosc_uic;
    }

    public void setNosc_uic(String nosc_uic) {
        this.nosc_uic = nosc_uic;
    }

    public String getPrd() {
        return prd;
    }

    public void setPrd(String prd) {this.prd = prd;}

    public String getEaos() {
        return eaos;
    }

    public void setEaos(String eaos) {this.eaos = eaos;}

    public String getCed() {
        return ced;
    }

    public void setCed(String ced) {this.ced = ced;}

    public String getReport_date() {
        return report_date;
    }

    public void setReport_date(String report_date) {this.report_date = report_date;}

    public String getRank_date() {
        return rank_date;
    }

    public void setRank_date(String rank_date) {this.rank_date = rank_date;}

    public String getClearance_date() {
        return clearance_date;
    }

    public void setClearance_date(String clearance_date) {this.clearance_date = clearance_date;}
}
