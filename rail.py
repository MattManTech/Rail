import subprocess

from flask import Flask, request

app = Flask("my_app1")



@app.route("/rail")
def rail_schedule():
    if 'outformat' in request.args:
        outformat = request.args.get('outformat')
    else:
        outformat = "html"
    if 'departure' in request.args:
        departure = request.args.get('departure')
    else:
        departure = "html"
    if 'arrive' in request.args:
        arrive = request.args.get('arrive')
    else:
        arrive = "html"
    if 'time' in request.args:
        time = request.args.get('time')
    else:
        time = "html"
    return subprocess.check_output(["java", "-classpath", "/home/afeka/tsclient/matan/eclipse-workspace/Rail/src", "railForPycharm/Main",
                                    outformat,departure,arrive,time])


app.run()
