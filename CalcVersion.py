import os

str1=os.getcwd()
str2=str1.split('\\')
n=len(str2)

print str2[n-1]
print str1

version = "1.0.0"
subversion = 000

print "Setting new version of mod"

def main():
    print("Obtaining version information for mod")
    
    with open("lcver.properties","w") as f:
      f.write("%s=%s\n" %("lc.build.major.number",major))
      f.write("%s=%s\n" %("lc.build.minor.number",minor))
      f.write("%s=%s\n" %("lc.build.revision.number",rev))
      f.write("%s=%s\n" %("lc.build.revision.number",sub))
      f.write("%s=%s\n" %("lc.build.mcpversion",mcpversion))
      f.write("%s=%s\n" %("lc.build.mcclientversion",mcclientversion))
      f.write("%s=%s\n" %("lc.build.mcserverversion",mcserverversion))

    print("Version information: Logisticraft %s.%s.%s_%s using MCP %s for c:%s, s:%s" % (major, minor, rev, sub, mcpversion, mcclientversion, mcserverversion))