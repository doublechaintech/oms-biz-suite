
MODELNAME=oms
cd ~/githome/-biz-suite/&& git pull --allow-unrelated-histories && cd ../
cd ~/githome/-biz-suite/bizcore&& gradle classes && cd ../../
cd ~/githome/-biz-suite/ && rsync -avz   bizcore/* philipz@philip.doublechaintech.cn:~/resin-3.1.12/webapps//


