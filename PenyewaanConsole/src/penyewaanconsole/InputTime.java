/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package penyewaanconsole;

/**
 *
 * @author asus
 */
import java.util.Scanner;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
public class InputTime{
    //instansiasi scanner
    Scanner input = new Scanner(System.in);
    //instansiasi olahdata
    OlahDataMember olah = new OlahDataMember();
    //ID Member
    protected String inputID(){
        System.out.print("Masukan ID                    : ");
        String ID = input.nextLine();
        return ID;     
    }
    private int inputTglPinjam(){
        int TglPinjam;
        while (true){
            System.out.print("Masukan Tanggal Pinjam (1-31) : ");
            Integer TglPinjm = input.nextInt();
            if (TglPinjm < 1){
                System.out.println("Tanggal salah. Masukan kembali.");
            }
            else if (TglPinjm > 31){
                System.out.println("Tanggal salah. Masukan kembali.");
            }
            else {
               TglPinjam = TglPinjm;
               break;
            }
        }
        return TglPinjam;
    }
    private int inputBulanPinjam(){
        int BulanPinjam;
        while (true){
            System.out.print("Masukan Bulan Pinjam (1-12)   : ");
            Integer inputBulan = input.nextInt();
            if (inputBulan < 1){
                System.out.println("Bulan salah. Masukan kembali.");
            } else if (inputBulan > 12) {
                System.out.println("Bulan salah. Masukan kembali.");
            } else {
                BulanPinjam = inputBulan;
                break;
            }
        }
        return BulanPinjam;  
    }
    private int inputTahunPinjam(){
        System.out.print("Masukan Tahun Pinjam          : ");
        int TahunPinjam = input.nextInt();
        return TahunPinjam;
    }
    
    
    private int inputTanggalKembali(){
        int TanggalKembali;
        while (true){
            System.out.print("Masukan tanggal kembali (1-31): ");
            Integer inputTgl = input.nextInt();
            if (inputTgl < 1){
                System.out.println("Tanggal salah. Masukan kembali.");
            } else if (inputTgl > 31){
                System.out.println("Tanggal salah. Masukan kembali.");
            } else {
                TanggalKembali = inputTgl;
                break;
            }
        }
        return TanggalKembali;
    }
    private int inputBulanKembali (){
        int BulanKembali;
        while (true){
            System.out.print("Masukan bulan kembali (1-12)  : ");
            Integer inputBln = input.nextInt();
            if (inputBln < 1){
                System.out.println("Bulan salah. Masukan kembali.");
            } else if (inputBln > 31){
                System.out.println("Bulan salah. Masukan kembali.");
            } else {
                BulanKembali = inputBln;
                break;
            }
        }
        return BulanKembali;
    }
    private int inputTahunKembali(){
        System.out.print("Masukan Tahun Kembali         : ");
        int TahunKembali = input.nextInt();
        return TahunKembali;
    }
    
    private LocalDate waktuPinjam, waktuKembali;
    protected int lamaSewa;
    void inputwaktu(){
        int tglPinjam = this.inputTglPinjam();
        int blnPinjam = this.inputBulanPinjam();
        int thnPinjam = this.inputTahunPinjam();
        this.waktuPinjam = LocalDate.of(thnPinjam, blnPinjam, tglPinjam);
        
        int tglKembali = this.inputTanggalKembali();
        int blnKembali = this.inputBulanKembali();
        int thnKembali = this.inputTahunKembali();
        this.waktuKembali = LocalDate.of(thnKembali, blnKembali, tglKembali);
        
        this.lamaSewa = (int) ChronoUnit.DAYS.between(this.waktuPinjam, this.waktuKembali);
        if (this.lamaSewa < 1){
            System.out.println("Waktu peminjaman tidak valid. Pinjam minimal 1 hari.");
            System.exit(0);
        }
    }
    
    protected void outputWaktu(){
        System.out.println("");
        System.out.println("Tanggal Pinjam          : " + this.waktuPinjam );
        System.out.println("Tanggal Kembali         : "  + this.waktuKembali);
        System.out.println("Lama Sewa               : "  + this.lamaSewa + " hari");
        System.out.println("");
    }
}
