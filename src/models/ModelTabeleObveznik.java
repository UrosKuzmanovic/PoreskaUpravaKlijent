/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import domen.Obveznik;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Ookee
 */
public class ModelTabeleObveznik extends AbstractTableModel {

    private ArrayList<Obveznik> listaObveznika;
    private String[] kolone = {"Broj obveznika", "Ime", "Prezime", "JMBG", "Adresa"};

    public ModelTabeleObveznik() {
        listaObveznika = new ArrayList<>();
    }

    @Override
    public int getRowCount() {
        return listaObveznika.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Obveznik o = listaObveznika.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return o.getBrObveznika();
            case 1:
                return o.getIme();
            case 2:
                return o.getPrezime();
            case 3:
                return o.getJmbg();
            case 4:
                return o.getAdresa();
            default:
                return "";
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    public void dodajObveznika(Obveznik o) {
        listaObveznika.add(o);
        fireTableDataChanged();
    }

    public void obrisiObveznika(Obveznik o) {
        listaObveznika.remove(o);
        fireTableDataChanged();
    }

    public ArrayList<Obveznik> getListaObveznika() {
        return listaObveznika;
    }

    public void setListaObveznika(ArrayList<Obveznik> listaObveznika) {
        this.listaObveznika = listaObveznika;
        fireTableDataChanged();
    }

}
