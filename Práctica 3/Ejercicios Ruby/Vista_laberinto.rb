class Vista_laberinto
  def initialize (controlador)
    @controlador = controlador
end

class Vista_laberinto
  def menu_usuario
    estado=@controlador.estado
    case estado
    when Estado_juego::EN_ENTRADA_LABERINTO
      puts "¿Con cuántas vidas empiezas?"
      STDOUT.flush
      vidas = gets.chomp

    when Estado_juego::DENTRO_VIVO
      informe_dentro(to_s(@controlador.habitacion_usuario),to_s(vidas))
      puts "Pulse enter"
      STDOUT.flush
      @controlador.intenta_avanzar
    when Estado_juego::EN_SALIDA_LABERINTO
      informe_final(to_s(@controlador.vidas))

    when Estado_juego::DENTRO_MUERTO
      informe_final(to_s(@controlador.vidas))
    end
  end

    def informe_dentro(hab,vidas)
      puts "Está en la habitacion " + to_s(hab) + " y tiene " + to_s(vidas) #hab.to_s
    end

    def informe_final(vidas)
      if (vidas == 0)
        puts "Sa muerto paco....\n"
        puts "Vidas: " + to_s(vidas)
        exit 0
      else
        puts "Vidas restantes: " + to_s(vidas)
      end
    end
end
end