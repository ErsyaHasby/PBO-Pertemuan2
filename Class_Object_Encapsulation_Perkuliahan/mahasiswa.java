class mahasiswa {
    private String nama;
    private String nim;
    private int nilai;

    public mahasiswa(String nama, String nim) {
        this.nama = nama;
        this.nim = nim;
    }
    public void setnilai(int nilai) {
        this.nilai = nilai;
    }
    public int getnilai() {
        return this.nilai;
    }

    public String getNama() {
        return this.nama;
    }

    public String getNim() {
        return this.nim;
    }
    @Override
    public String toString() {
        return "Nama : " + this.nama + "\nNim : " + this.nim + "\nNilai : " + this.nilai;
    }

}


