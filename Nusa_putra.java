package sesi3;
import java.util.ArrayList;
import java.util.Scanner;

public class Nusa_putra extends Mahasiswa {
    Nusa_putra(String nama, String nim, int nilai){
        super(nama, nim, nilai);
    }
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       
       ArrayList <Mahasiswa> mhs = new ArrayList<>();
       ArrayList <Mahasiswa> lulus = new ArrayList<>();
       ArrayList <Mahasiswa>tidaklulus = new ArrayList<>();
       
       for (int i= 0; i < 4; i++){
            System.out.println("masukan NIM: ");
            String nim = sc.nextLine();
            
            System.out.println("masukan Nama: ");
            String nama = sc.nextLine();
            
            System.out.println("masukan Nilai: ");
            int nilai = Integer.parseInt(sc.nextLine());
            
            mhs.add(new Mahasiswa(nama, nim, nilai));
            if((mhs.get(i).getGrade().compareTo("A") == 0) || (mhs.get(i).getGrade().compareTo("B") == 0) ||(mhs.get(i).getGrade().compareTo("C") == 0)){
                lulus.add(new Mahasiswa(nama, nim, nilai));
            }
            else {
                tidaklulus.add(new Mahasiswa(nama, nim, nilai));
            }
            System.out.println("===================================");
    }
        System.out.println("jumlah mahasiswa : " + mhs.size());
        System.out.println("jumlah mahasiswa yang lulus : ");
        printMhs(lulus);
        System.out.println("jumlah mahasiswa yang tidak lulus: ");
        printMhs(tidaklulus);
        printNilai(mhs, "A");
        printNilai(mhs, "B");
        printNilai(mhs, "C");
        printNilai(mhs, "D");
        printNilai(mhs, "E");
        System.out.println();
        System.out.println("rata-rata nilai: ");
        rataRata(mhs);
        
        sc.close();
    
    }
    public static void printMhs(ArrayList<Mahasiswa> mhs) {
        System.out.println(mhs.size() + "yaitu ");
        for (int i = 0; i < mhs.size(); i++){
            System.out.println(mhs.get(i).getNama()+",");
        }
        System.out.println();
        
    }
    public static void printNilai(ArrayList<Mahasiswa>mhs, String nilai) {
        if(jumlahGrade(mhs, nilai)>0){
            System.out.println();
            System.out.println("jumlah mahasiswa dengan nilai" + nilai + ":" + jumlahGrade(mhs,nilai) + "yaitu" );
        }
        for(int i = 0; i < mhs.size(); i++){
            if(mhs.get(i).getGrade().equals(nilai)){
                System.out.println(mhs.get(i).getNama() + ",");
            }
        }
    }
    public static int jumlahGrade(ArrayList<Mahasiswa> mhs, String nilai){
        int jumlah = 0;
        for(int i = 0; i < mhs.size(); i++){
            if(mhs.get(i).getGrade().equals(nilai)){
                jumlah++;
            }
        }
        return jumlah;
    }
    public static float rataRata(ArrayList<Mahasiswa> mhs){
        System.out.println();
        int jumlah = 0;
        for(int i = 0; i <mhs.size();i++){
            if(mhs.get(i).getNilai() <= 100 & mhs.get(i).getNilai() >=0){
                jumlah += mhs.get(i).getNilai();
                System.out.println(mhs.get(i).getNilai() + "+");
            }
            else{
                System.out.println("0 + ");
            }
        }
        System.out.println(" = " + (float)jumlah/mhs.size());
        
        return jumlah / mhs.size();
    }
}
