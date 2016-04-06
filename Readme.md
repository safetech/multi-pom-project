 # Required Environment Variables

## DB Queries
Need to set two environment variables
DBUN = username with access to compas SYS1 database
DBPW = password for username with access to SYS1 database

## Selenium Driver for Firefox
Recent updates to firefox run really slow with selenium, so it is best to have a local installation of firefox 29.  You can get it here: https://ftp.mozilla.org/pub/mozilla.org/firefox/releases/29.0.1/mac/en-US/.
Then create the following environment variable

webdriver.firefox.bin = path to firefox binary (ie. 
```
webdriver.firefox.bin=/Users/awesomedev/dev/apps/firefox/firefox-29/Firefox.app/Contents/MacOS/firefox
```
