package com.jhon.webservices.presentador;

import android.content.Context;

import com.jhon.webservices.database.Constructorcontactos;
import com.jhon.webservices.fragment.ReciclerviewFragmentview;
import com.jhon.webservices.pojo.Contacto;

import java.util.ArrayList;

public class FavoritaPresentador implements IRecyclerViewPresentador {


        private ReciclerviewFragmentview reciclerviewFragmentview;
        private Context context;
        private Constructorcontactos constructorcontactos;
        private ArrayList<Contacto> contactos;

        public FavoritaPresentador(ReciclerviewFragmentview reciclerviewFragmentview, Context context) {
            this.reciclerviewFragmentview = reciclerviewFragmentview;
            this.context = context;
            obtenercontactosbasedatos();
        }

        @Override
        public void obtenercontactosbasedatos() {
            constructorcontactos = new Constructorcontactos(context);
            contactos=constructorcontactos.obtenerfavoritos();
            mostrarcontactosRv();
        }

        @Override
        public void mostrarcontactosRv() {
            reciclerviewFragmentview.InicializarAdaptadorRV(reciclerviewFragmentview.crearadaptador(contactos));
            reciclerviewFragmentview.generarLinearLayout();
        }
    }

