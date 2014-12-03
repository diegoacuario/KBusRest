/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

Ext.onReady(function() {

    var storeInformation = Ext.create('Ext.data.Store', {
        autoLoad: true,
        proxy: {
            type: 'ajax',
            url: 'webresources/com.kradac.kbus.rest.entities.historic.informacionparadas/parada=70',
            reader: {
                type: 'json',
                root: 'data'
            }
        },
        fields: [
            {name: 'regMunicipal', type: 'string'},
            {name: 'ruta', type: 'string'},
            {name: 'horaLlegada', type: 'string'},
            {name: 'horaArribo', type: 'string'}
        ]
    });

    var panelMenu = Ext.create('Ext.form.Panel', {
        region: 'north',
        border: true,
        items: [{
                layout: 'hbox',
                items: [{
                        xtype: 'label',
                        html: '<img src="img/situ.png" width="70" height="50">'
                    }, {
                        padding: '20 2 10 10',
                        height: 50,
                        xtype: 'label',
                        html: '<div id="encabezado">SISTEMA INTERMODAL DE TRANSPORTE URBANO</div>'
                    }]
            }
        ]
    });

    var gridInformation = Ext.create('Ext.grid.Panel', {
        region: 'west',
        title: '<b>Parada: </b>Parque Central',
        width: '60%',
        store: storeInformation,
        viewConfig: {
            loadMask: false,
            preserveScrollOnRefresh: true
        },
        columns: [
            {header: "<b>Registro<br>Municipal</b>", width: 100, align: 'center', dataIndex: 'regMunicipal'},
            {header: "<b>Ruta</b>", flex: 1, align: 'center', dataIndex: 'ruta'},
            {header: "<b>Tiempo<br>llegada</b>", width: 100, align: 'center', dataIndex: 'horaLlegada'},
            {header: "<b>Tiempo<br>Restante</b>", width: 100, align: 'center', dataIndex: 'horaArribo'}
        ]
    });

    var panelVideo = Ext.create('Ext.panel.Panel', {
        region: 'center',
        border: true,
        items: [{
                html: 'Agregar Video'
            }]
    });

    var panelPasamensajes = Ext.create('Ext.panel.Panel', {
        region: 'south',
        border: true,
        items: [{
                html: 'Agregar Pasamensajes'
            }]
    });

    var panelCentral = Ext.create('Ext.form.Panel', {
        region: 'center',
        layout: 'border',
        items: [
            panelVideo, gridInformation
        ]
    });

    Ext.create('Ext.container.Viewport', {
        layout: 'border',
        items: [panelMenu, panelCentral, panelPasamensajes]
    });

    reloadStore(storeInformation, 5);

});

function reloadStore(store, seconds) {
    setTimeout(function() {
        reloadStore(store, seconds);
        store.reload();
    }
    , seconds * 1000);
}