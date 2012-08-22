import os
import datetime
import time

file_location = os.getcwd()
prop_file = file_location + "\lcver.properties"
major = 1
minor = 0
rev = 0
sub = "000"
mcpversion = 72
mcclientversion = "1.3.2"

def file_exists(filename):
    try:
        with open(filename) as f:
            return True
    except IOError:
        return False

def read():
    with open("lcver.properties","r") as f:
        f.readline()

def write():
    #t = datetime.time
    #today = datetime.date.today()
    #date = str(today.day) + "." + str(today.month) + "." + str(today.year) + ". - " + str(t.hour) + str(t.min) + str(t.second)
    date = time.asctime(time.localtime(time.time()))
    with open("lcver.properties","w") as f:
        f.write("# %s \n" %(date))
        f.write("%s=%s\n" %("lc.build.major.number",major))
        f.write("%s=%s\n" %("lc.build.minor.number",minor))
        f.write("%s=%s\n" %("lc.build.revision.number",rev))
        f.write("%s=%s\n" %("lc.build.subversion.number",sub))
        f.write("%s=%s\n" %("lc.build.mcpversion",mcpversion))
        f.write("%s=%s\n" %("lc.build.mcclientversion",mcclientversion))

def main():
    print("[PY]Obtaining version information for mod")
    if file_exists(prop_file):
        print("[PY]Properties file exists: reading...")
        read()
    else:
        print("[PY]Properties file does not exists: writting...")
        write()
        
    print("[PY]Version information: Logisticraft %s.%s.%s_%s using MCP %s for c:%s" % (major, minor, rev, sub, mcpversion, mcclientversion))
    
if __name__ == '__main__':
    main()