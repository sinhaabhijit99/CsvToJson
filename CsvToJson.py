import csv
import json
import sys
#inputFile: input text file address
#outputFIle: output json file address
def CsvToJson (inputFile, outputFile):
    with open(inputFile) as csvfile:
        reader = csv.reader(csvfile, delimiter = ',')
        keys = reader.next()
        jsonObj = [dict(zip(keys,prop)) for prop in reader]
        print json.dumps(jsonObj)
        filewriter = open(str(outputFile),'w')
        filewriter.write(json.dumps(jsonObj,indent=4))
        filewriter.close();

if __name__=="__main__":
    if(len(sys.argv)!=2):
        print "2 arguments required"
    else:
        CsvToJson(sys.argv(0), sys.argv(1))

    
       
    
