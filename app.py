import subprocess

import flask
from flask import Flask, request, render_template, send_file

app = Flask(__name__)


@app.route("/")
def main():
    return render_template('Rail.html')

@app.route("/image")
def image():
    return send_file('train.jpg')

@app.route("/iframe")
def iframe():
    return ""

@app.route("/search")
def search():
    return subprocess.check_output(["java", "-classpath",
                                    "/home/matan/eclipse-workspace/Rail/bin", "RailMain",
                                    request.args.get('outformat'), request.args.get('departure'),
                                    request.args.get('arrive'), request.args.get('time')])
                                    
                                   


app.run()
