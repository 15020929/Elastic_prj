def msg= doc['message'].value;
def tag=doc['tag'].value;
def fieldArr = msg.toString().splitOnToken('|');
Map formats= new HashMap();
….
formats.put('CCAMsg','Session = %s|Dialog = %s|Calling Number = %s|CC-Request-Type = %s|ResultCode = %s|expireDate = %s|language_id = %s|Reserve Time = %s');
formats.put('TCEnd','Dialog=%s|Instance=%s|RaId=%s|Invoke=%s%s|Type=%s');
try{
    return String.format(formats.get(tag),fieldArr);
} catch (Exception ex){
    return '\nException:: ' + ex.toString();
}