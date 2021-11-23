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
public class PenyewaanConsole {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //instansiasi olahdatamember dan menambahkan member sekaligus
        OlahDataMember olah = new OlahDataMember();
        olah.tambahMember(new Member("M001","Mr.X","Silver"));
        olah.tambahMember(new Member("M002","Mr.Y","Gold"));
        olah.tambahMember(new Member("M003","Mr.Z","Platinum"));

        //instansiasi input
        InputTime time = new InputTime();
        
        //perulangan jika hasil ID salah
        String IDMember;
        while (true){
            String ID = time.inputID();
            boolean cek = olah.cekID(ID);
            if (cek == true){
                IDMember = ID;
                break;
            } else {
                System.out.println(ID + " tidak ditemukan. Masukan lagi.");
            }
        }
        //input waktu
        time.inputwaktu();
        
        //Output ID
        System.out.println("");
        olah.cariMember(IDMember);
        //Output waktu
        time.outputWaktu();
        
        //Output biaya
        String jenis;
        jenis = olah.dataMember.get(olah.cariIndex(IDMember)).JenisMember;
        switch (jenis) {
            case "Silver":
                BenefitSilver silver = new BenefitSilver();
                silver.outputBiaya(time.lamaSewa);
                break;
            case "Gold":
                BenefitGold gold = new BenefitGold();
                gold.outputBiaya(time.lamaSewa);
                break;
            case "Platinum":
                BenefitPlatinum plat = new BenefitPlatinum();
                plat.outputBiaya(time.lamaSewa);
        }
        
    }
    
    
}
