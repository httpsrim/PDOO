module Herencia
    class Persona
    def initialize(nombre,h)
      @nombre = nombre
      @horas_entreno = h
    end
    def andar
      result = "Soy #{@nombre} y estoy andando\n"
    end
    def to_s
      result = "Soy una persona y mi nombre es #{@nombre}\n"
    end
  end
  class Deportista<Persona
    def initialize(n,h)
      super(n,h)
      @horas_entreno = h
    end
    def competicion_deportiva
      print("Entreno #{@horas_entreno} horas\n")
    end
  end
  class Nadador<Deportista
    def initialize(n,h)
      super(n,h)
    end
  def nadar
    result = "Soy #{@nombre} y estoy nadando\n"
  end
  def to_s
    result = "#{super} y además soy nadador\n"
  end
  end
  class Corredor<Deportista
    def initialize(n,h)
      super(n,h)
    end
    def correr
      result = "Soy #{@nombre} y estoy corriendo\n"
    end
    def to_s
      result = "#{super} y además soy corredor\n"
    end
  end
    #funciona con y sin constructor.
    p1=Persona.new("Antonio",0)
    d1=Deportista.new("Pablo",2)
    c1=Corredor.new("Pepe",4)
    n1=Nadador.new("Juan",5)
    print("Ejercicio 2 \n")
    print(c1.andar)
    print(n1.andar)
    print(d1.andar)
    print(p1.andar)
    print("Ejercicio 3")
    print(c1.correr)
    print(c1.competicion_deportiva)
    print(c1.to_s)
    print(c1.andar)
    print(n1.nadar)
    print(n1.competicion_deportiva)
    print(n1.to_s)
    print(n1.andar)
    print(d1.andar)
    print(d1.competicion_deportiva)
    print(d1.to_s)
    print(p1.andar)
    print(p1.to_s)
end