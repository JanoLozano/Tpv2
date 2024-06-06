package parcial2;

import java.util.LinkedList;

import javax.swing.JOptionPane;

class GestorEquipos {
	private LinkedList<Equipo> listaEquipos;

	public GestorEquipos(LinkedList<Equipo> listaEquipos) {
		super();
		this.listaEquipos = listaEquipos;
	}
	public LinkedList<Equipo> getListaEquipos() {
		return listaEquipos;
	}

	public void setListaEquipos(LinkedList<Equipo> listaEquipos) {
		this.listaEquipos = listaEquipos;
	}

	@Override
	public String toString() {
		return "GestorEquipos [listaEquipos=" + listaEquipos + "]";
	}
	
	// Metodo agregarEquipo---------------
	public void agregarEquipo(LinkedList<Equipo> listaEquipos) {
	    // Verificar si ya hay dos equipos en la lista
	   if (listaEquipos.size() >= 2) {
	        JOptionPane.showMessageDialog(null, "No pueden existir más de dos equipos.");
	        return;
	    }
	     /*String nombreEquipo;
	    boolean flag = false;
	    do {
	        nombreEquipo = JOptionPane.showInputDialog("Ingrese el nombre del equipo");

	        // Verificar si el nombre del equipo ya existe en la lista
	        boolean equipoExistente = false;
	        for (Equipo equipo : listaEquipos) {
	            if (equipo.getNombreEquipo().equalsIgnoreCase(nombreEquipo)) {
	                JOptionPane.showMessageDialog(null, "Ya existe un equipo con ese nombre.");
	                equipoExistente = true;
	            }
	        }

	        if (!equipoExistente && !nombreEquipo.isEmpty()) {
	            // Si no hay ningun equipo con el mismo nombre y el nombre no está vacío, agregar el nuevo equipo
	            Equipo nuevoEquipo = new Equipo(nombreEquipo, new LinkedList<>());
	            listaEquipos.add(nuevoEquipo);
	            JOptionPane.showMessageDialog(null, "Equipo agregado con éxito.");
	            flag = true; // Poner flag en true para salir del bucle
	        } else if (nombreEquipo.isEmpty()) {
	            JOptionPane.showMessageDialog(null, "Por favor ingrese un nombre de equipo.");
	        }
	    } while (!flag);*/
	   	
		Equipo skt = new Equipo("skt", new LinkedList<>());
		Equipo fan = new Equipo("fnatic", new LinkedList<>());
        listaEquipos.add(skt);
        listaEquipos.add(fan);
	
}



    
    // Metodo eliminarEquipo---------------
    public void eliminarEquipo(LinkedList<Equipo> listaEquipos, LinkedList<Jugador> listaJugadores) {
        // Verificar si hay equipos con este nombre
        if (this.listaEquipos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay ningún equipo creado.");
            return;
        }

        // Construir mensaje con los nombres de los equipos existentes
        String mensajeEquipos = "Equipos existentes:\n";
        for (Equipo equipo : this.listaEquipos) {
            mensajeEquipos += equipo.getNombreEquipo() + "\n";
        }

        // Solicitar selección de equipo a eliminar
        String equipoEliminar = (String) JOptionPane.showInputDialog(
                null,
                "Seleccione el equipo que desea eliminar:",
                "Eliminar Equipo",
                JOptionPane.QUESTION_MESSAGE,
                null,
                mensajeEquipos.split("\n"),
                mensajeEquipos.split("\n")[0]
        );

        // Buscar el equipo en la lista de equipos
        Equipo equipoAEliminar = null;
        for (Equipo equipo : this.listaEquipos) {
            if (equipo.getNombreEquipo().equals(equipoEliminar)) {
                equipoAEliminar = equipo;
                break;
            }
        }

        // Verificar si se encontró el equipo
        if (equipoAEliminar != null) {
            // Eliminar el equipo de la lista de equipos
            this.listaEquipos.remove(equipoAEliminar);

            // Eliminar los jugadores asociados al equipo de la lista global de jugadores
            for (Jugador jugador : equipoAEliminar.getListaJugadores()) { // este foreach lo que hace es iterar jugador sobre la cantidad de jugadores que haya segun el equipo elegido
                listaJugadores.remove(jugador);
            }

            // Mostrar mensaje de éxito
            JOptionPane.showMessageDialog(null, "Equipo " + equipoAEliminar.getNombreEquipo() + " eliminado con éxito.");
        } else {
            // Si no se encontro el equipo, mostrar un mensaje
            JOptionPane.showMessageDialog(null, "El equipo seleccionado no fue encontrado.");
        }
    }

    
    // Metodo buscarEquipoPorNombre--------------
    public void buscarEquipoPorNombre() {
    	// Verificar si hay equipos existentes
    	if (this.listaEquipos.isEmpty()) {
        	JOptionPane.showMessageDialog(null, "No hay ningun equipo creado.");
            return;
        }
    	// Armar mensaje para poder mostrar los equipos
    	String mensajeEquipos = "";
        for (Equipo eq : listaEquipos) {
            mensajeEquipos += "-" +eq.getNombreEquipo() + "\n";
        }
        
        // Preguntar al usuario
    	String equipoElegido = JOptionPane.showInputDialog("Ingrese el nombre del equipo que desea ver los datos: \n"
    			+ "" + mensajeEquipos);
    	
    	// Verificar si el equipo elegido es igual al de la lista
    	for (Equipo equipo : listaEquipos) {
            if (equipo.getNombreEquipo().equalsIgnoreCase(equipoElegido)) {
                
                String mensaje = "Nombre del equipo: " + equipo.getNombreEquipo() + "\nJugadores:\n";
                for (Jugador jugador : equipo.getListaJugadores()) {
                    mensaje += "- " + jugador.getNombreJugador() + "\n";
                }
                JOptionPane.showMessageDialog(null, mensaje);
                return;
            }
        }
    	// Si no se encuentra el equipo
        JOptionPane.showMessageDialog(null, "El equipo no fue encontrado.");
    }
    
    // Metodo cantidadTotalDeEquipos--------------
    public void cantidadTotalDeEquipos(LinkedList<Equipo> listaEquipos) {
    	if (listaEquipos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay equipos en la lista");
            return;
        }
    	int cantidadEquipos = listaEquipos.size();
            JOptionPane.showMessageDialog(null, "la cantidad de equipos son: " + cantidadEquipos );
            return;
    }
    // Metodo mostrarListaDeEquipos------------
    public void mostrarListaDeEquipos() {
    	 String mensajeEquipos = "";
         for (Equipo eq : listaEquipos) {
             mensajeEquipos += eq.getNombreEquipo() + "\n";
         }
         JOptionPane.showMessageDialog(null, "Lista de equipos:\n" + mensajeEquipos );
    }
 // Metodo jugarPartida
    public void jugarPartida(LinkedList<Equipo> listaEquipos,LinkedList<Jugador> listaJugadores ) {
    	// Verificar que existan equipos
    	if (listaEquipos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay equipos en la lista");
            return;
        }
    	// Verificar que no sean menos de dos equipos
    	if (listaEquipos.size() < 2) {
            JOptionPane.showMessageDialog(null, "Debe haber al menos dos equipos para jugar una partida.");
            return;
        }
    	// Verificar que hayan jugadores en la lista de los equipos
    	if (listaJugadores.isEmpty()) {
    		JOptionPane.showMessageDialog(null, "No hay jugadores en la lista de los equipos");
            return;
		}
    	// Verificar que hayan 5 jugadores en cada equipo
    	if (listaJugadores.size() < 10) { // Si el tamaño de la lista es menor a 10 significa que no hay 5 jugadores en cada equipo ya que no se pueden agregar mas de 5 por equipo
    		JOptionPane.showMessageDialog(null, "deben haber 5 jugadores en cada equipo");
            return;
		}
    	// Creacion variable Equipo que contiene la lista de los equipos segun parametro
    	Equipo equipo1 = listaEquipos.get(0);
    	Equipo equipo2 = listaEquipos.get(1);
    	
    	int contVictoriasEquipo1 = 0;
    	int contVictoriasEquipo2 = 0;
    	
    	// Bucle que continua siempre que las victorias sean menor a 3
    	while (contVictoriasEquipo1 < 3 && contVictoriasEquipo2 < 3) {
    		int resultado = (int) (Math.random() * 2); // 0 o 1
			
    		 if (resultado == 0) {
    			 contVictoriasEquipo1++;
             } else {
            	 contVictoriasEquipo2++;
             }
    		 
    		 String mensajeResultado = "Resultado de la partida:\n" +
    				 equipo1.getNombreEquipo() + ": " + contVictoriasEquipo1 + " victorias\n" +
    				 equipo2.getNombreEquipo() + ": " + contVictoriasEquipo2 + " victorias";
    		 
    		 JOptionPane.showMessageDialog(null, mensajeResultado);	
		}
    	
    	String mensajeGanador;
        if (contVictoriasEquipo1 == 3) {
            mensajeGanador = "El ganador es " + equipo1.getNombreEquipo() + " con 3 victorias.";
        } else {
            mensajeGanador = "El ganador es " + equipo2.getNombreEquipo() + " con 3 victorias.";
        }
        JOptionPane.showMessageDialog(null, mensajeGanador);
    }
}