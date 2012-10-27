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
list = []

major = "1"
minor = "1"
rev = "0"
sub = "000"
mcpversion = "7.19"
forgeversion = "6.0.1.339"
mcclientver = "1.4.2"

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
    
def calc():
    global major
    global minor
    global rev
    global sub
    global mcpversion
    global mcclientver
    
    major = list[0]
    minor =  list[1]
    rev =  list[2]
    sub = list[3]
    subver = int(sub)
    subver += 1
    sub = str(subver).zfill(3)
    mcpversion = list[4]
    mcclientver = list[5]

def read():
    with open(prop_file,"r") as f:
        lines = f.readlines()        
        for line in lines:
            line = line.strip()
            if not '#' in line:
                split = line.split('=')
                list.append(split[1])
        f.close()

def write():
    date = time.asctime(time.localtime(time.time()))
    with open("lcver.properties","w+") as f:
        f.write("# %s \n" %(date))
        f.write("%s=%s\n" %("lc.build.major.number",major))
        f.write("%s=%s\n" %("lc.build.minor.number",minor))
        f.write("%s=%s\n" %("lc.build.revision.number",rev))
        f.write("%s=%s\n" %("lc.build.subversion.number",sub))
        f.write("%s=%s\n" %("lc.build.mcpversion",mcpversion))
        f.write("%s=%s\n" %("lc.build.forgeversion",forgeversion))
        f.write("%s=%s\n" %("lc.build.mcclientversion",mcclientver))
        f.write("%s=%s.%s.%s_%s\n" %("lc.build.build",major, minor, rev, sub))
        f.close()
        
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
      print("[PY]Version information from git: Logisticraft %s.%s.%s_%s using MCP %s for c:%s" % (major, minor, rev, sub, mcpversion, mcclientver))

def main():
    print("[PY]Obtaining version information for mod")
    if file_exists(prop_file):
        print("[PY]Properties file exists: reading...")
        read()
        calc()
        write()
    else:
        print("[PY]Properties file does not exists: writting...")
        #getGit()
        write()
        
    print("[PY]"+time.asctime(time.localtime(time.time())))
    print("[PY]Version information: Logisticraft %s.%s.%s_%s using MCP %s and Forge %s for c:%s" % (major, minor, rev, sub, mcpversion, forgeversion, mcclientver))
    
if __name__ == '__main__':
    main()