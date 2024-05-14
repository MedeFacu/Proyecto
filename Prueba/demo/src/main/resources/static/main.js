$(document).ready(function() {
    // Método para cargar los datos desde la base de datos y mostrarlos en la página
    function cargarDatos() {
        $.ajax({
            type: "GET",
            url: "/presupuestos", // Ruta del controlador que devuelve los datos
            success: function(data) {
                // Recorrer los datos y mostrarlos en la página
                // Supongamos que los datos se muestran en una tabla con un id="tablaDatos"
                $("#tablaDatos").empty(); // Limpiar tabla antes de agregar datos nuevos
                $.each(data, function(index, presupuesto) {
                    $("#tablaDatos").append("<tr><td>" + presupuesto.donacion + "</td><td>" + presupuesto.gasto + "</td><td>" + presupuesto.ingreso + "</td><td>" + presupuesto.total + "</td></tr>");
                });
            },
            error: function() {
                alert("Error al cargar datos desde el servidor.");
            }
        });
    }

    // Llamar a la función para cargar los datos cuando la página esté lista
    cargarDatos();
});
