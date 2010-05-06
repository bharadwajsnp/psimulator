#!/bin/bash
# skript pro pripojeni klienta na cisco
# author haldyr

VERSION=`rlwrap -v | cut -d" " -f2 | sed 's/\./,/g'`
COLOR=green
COMPLETION=doplnovani_linux.txt

if [[ $VERSION -ge 0,32 ]]; then
    OPT="-I -p$COLOR -w-3"
fi

if [[ $VERSION -ge 0,29 && $VERSION -lt 0,32 ]]; then
    OPT="-p$COLOR"
fi

if [[ $VERSION -lt 0,29 ]]; then
    OPT=""
fi

OPT="$OPT -f $COMPLETION"

echo pouzivam OPT=$OPT

rlwrap $OPT telnet localhost $@