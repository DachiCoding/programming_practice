#!/usr/bin/env node --harmony
require('fs').createReadStream(process.argv[2]).pipe(process.stdout);
