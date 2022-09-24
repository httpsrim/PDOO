# encoding:utf-8
module EjerciciosRuby
  class Parcela
    def initialize(nombre,precio_compra,precio_base_alquiler,precio_edificar,num_casas,num_hoteles)
      @nombre = nombre
      @precio_compra = precio_compra
      @precio_base_alquiler = precio_base_alquiler
      @precio_edificar = precio_edificar
      @num_casas = num_casas
      @num_hoteles = num_hoteles
    end

    def nombre
      @nombre
    end

    def precioCompra
      @precio_compra
    end
    def precioEdificar
      @precio_edificar
    end
    def numCasas
      @num_casas
    end
    def numHoteles
      @num_hoteles
    end
    def precio_alquiler_completo
      precio_alquiler = @precio_base_alquiler*(1+@num_casas+(@num_hoteles*4))
    end
    def construir_casa
      @num_casas = @num_casas + 1
    end
    def construir_hotel
      @num_hoteles = @num_hoteles + 1
    end
    def getPrecioAlquilerDescuento(descuento,porc)
      if(descuento == true)
        precio_alquiler = @precio_base_alquiler*(1+@num_casas+(@num_hoteles*4))*(1-porc)
      end
      if(descuento == false)
        precio_alquiler = @precio_base_alquiler*(1+@num_casas+(@num_hoteles*4))
      end
    end
  sitio = Parcela.new('Juan Pablo',3,150,5,1,1)
  puts(sitio.precio_alquiler_completo)
  puts("Añadiendo hoteles...")
  sitio.construir_hotel
  puts(sitio.precio_alquiler_completo)
    descuento = false
    porc = 0.43
    puts(sitio.getPrecioAlquilerDescuento(descuento,porc))
  end
end