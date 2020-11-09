/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import domen.Rata;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Ookee
 */
public class ModelTabeleRata extends AbstractTableModel{
 
    private ArrayList<Rata> listaRata;
    private String[] kolone = {"Broj rate", "Iznos rate", "Rok za uplatu"};

    public ModelTabeleRata() {
        listaRata = new ArrayList<>();
    }

    @Override
    public int getRowCount() {
        return listaRata.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Rata r = listaRata.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return r.getBrRate();
            case 1:
                return new DecimalFormat("#.##").format(r.getIznosRate());
            case 2:
                return r.getRokZaUplatu();
            default:
                return "";
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    public void dodajRatu(Rata r) {
        listaRata.add(r);
        fireTableDataChanged();
    }

    public void obrisiRatu(Rata r) {
        listaRata.remove(r);
        fireTableDataChanged();
    }

    public ArrayList<Rata> getListaRata() {
        return listaRata;
    }

    public void setListaRata(ArrayList<Rata> listaRata) {
        this.listaRata = listaRata;
        fireTableDataChanged();
    }
    
}
