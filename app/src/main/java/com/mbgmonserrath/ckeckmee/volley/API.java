package com.mbgmonserrath.ckeckmee.volley;

public interface API {

    public String URL ="http://192.168.1.6/ws/";
    public String LISTARI=URL + "ApiI.php?api=listar";
    public String GUARDARGPO=URL + "ApiG.php?api=guardar";
    public String ELIMINARA=URL + "ApiG.php?api=eliminar";
    public String EDITARGPO=URL + "ApiG.php?api=editar";
    public String BUSCARE=URL + "ApiE.php?api=buscarE";

}
