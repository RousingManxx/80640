// regresa de forma textual los parámetros leidos con get
  const doGet = (e = {}) => {
    const { parameter } = e;
    const { nombre = 'Alex', apellido = 'GetTerrones', telefono, direccion} = parameter;
    const salida = `Hola :) ${nombre} ${apellido} ${telefono} ${direccion}`;
    return ContentService.createTextOutput(salida);
  };

// regresa de forma textual los parámetros leidos con post
  const doPost = (e = {}) => {
    const { parameter } = e;
    const { nombre = 'Alex', apellido = 'PostTerrones', telefono, direccion } = parameter;
    const salida = `Hola :) ${nombre} ${apellido} ${telefono} ${direccion}`;
    return ContentService.createTextOutput(salida);
  };
