import subprocess

import flask
from flask import Flask, request, render_template, send_file

app = Flask("Rail")

@app.route("/image")
def image():
    return send_file('train.jpg')


@app.route("/")
def main():
     if 'outformat' in request.args:
        outformat = request.args.get('outformat')
    else:
        outformat = "html"

    if 'departure' in request.args :
        startS = request.args.get('departure')
    else:
        startS ='null'

    if 'lastS' in request.args:
        lastS = request.args.get('arrive')
    else:
        lastS = 'null'

    if 'hour' in request.args:
        hour = request.args.get('hour')
    else:
        hour = 'null'

    if 'minutes' in request.args:
        minutes = request.args.get('minutes')
    else:
        minutes = 'null'


        
     return subprocess.check_output(["java", "-classpath",
                                    "/home/matan/eclipse-workspace/Rail/bin", "RailMain", outformat
                                   ,departure , arrive , hour, minutes])

        
                                    
                                   


app.run()
