import time
import os
import sys
import commands
import datetime
import fnmatch
import subprocess, shlex
import re

file_location = os.getcwd()
prop_file = file_location + "\lcver.properties"
major = 0
minor = 0
rev = 0
sub = "000"
mcpversion = 72
mcclientversion = "1.3.2"

def cmdsplit(args):
    if os.sep == '\\':
        args = args.replace('\\', '\\\\')
    return shlex.split(args)

def file_exists(filename):
    try:
        with open(filename) as f:
            return True
    except IOError:
        return False

def read():
    with open("lcver.properties","r") as f:
        line = f.readline()
        if not line.startsWith("#"):
            major = line.split("=")[1]

def write():
    #date = str(today.day) + "." + str(today.month) + "." + str(today.year) + ". - " + str(t.hour) + str(t.min) + str(t.second)
    date = time.asctime(time.localtime(time.time()))
    with open("lcver.properties","w+") as f:
        f.write("# %s \n" %(date))
        f.write("%s=%s\n" %("lc.build.major.number",major))
        f.write("%s=%s\n" %("lc.build.minor.number",minor))
        f.write("%s=%s\n" %("lc.build.revision.number",rev))
        f.write("%s=%s\n" %("lc.build.subversion.number",sub))
        f.write("%s=%s\n" %("lc.build.mcpversion",mcpversion))
        f.write("%s=%s\n" %("lc.build.mcclientversion",mcclientversion))
        
def getGit(): 
    print("[PY]Obtaining version information from github")
    comLine = "git describe --tags"     
    try:
      p = subprocess.Popen(comLine, stdout=subprocess.PIPE, stderr=subprocess.STDOUT, bufsize=-1)
      ver, _ = p.communicate()
    except OSError:
      print("Git not found")
      ver="1.0.0"
      (major,minor,rev)=re.match("(\d+).(\d+).(\d+)",ver).groups()
      print("[PY]Version information from git: Logisticraft %s.%s.%s_%s using MCP %s for c:%s" % (major, minor, rev, sub, mcpversion, mcclientversion))

def main():
    print("[PY]Obtaining version information for mod")
    if file_exists(prop_file):
        print("[PY]Properties file exists: reading...")
        read()
    else:
        print("[PY]Properties file does not exists: writting...")
        #getGit()
        write()
        
    print("[PY]Version information: Logisticraft %s.%s.%s_%s using MCP %s for c:%s" % (major, minor, rev, sub, mcpversion, mcclientversion))
    
if __name__ == '__main__':
    main()