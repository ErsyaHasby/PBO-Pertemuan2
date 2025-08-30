class MataKuliah {
    private String namaMataKuliah;
    private String dosen;
    private int sks;

    public MataKuliah(String namaMataKuliah, String dosen, int sks) {
        this.namaMataKuliah = namaMataKuliah;
        this.dosen = dosen;
        this.sks = sks;
    }

    public void setSks(int sks) {
        this.sks = sks;
    }
    public int getSks() {
        return this.sks;
    }
    public String getNamaMataKuliah() {
        return this.namaMataKuliah;
    }
    public String getDosen() {
        return this.dosen;
    }
    @Override
    public String toString() {
        return "Nama Mata kuliah : "+ this.namaMataKuliah + "\n" + "Nama Dosen : "+ this.dosen + "\nSks : " + this.sks;
    }
}

