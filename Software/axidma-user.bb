
SUMMARY = "AXI DMA ctrl-ring kernel driver (axidma_user) and userspace test application"
SECTION = "PETALINUX/modules"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${WORKDIR}/git/LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"
inherit module

INHIBIT_PACKAGE_STRIP = "1"

SRC_URI = "git://github.com/Sanjay0302/axidma-user.git;protocol=https;branch=main"
# SRCREV = "${AUTOREV}"

S = "${WORKDIR}/git/driver"
USERSPACE_DIR = "${WORKDIR}/git/userspace"

do_compile:append() {
    oe_runmake -C ${USERSPACE_DIR} clean
    oe_runmake -C ${USERSPACE_DIR} \
        CC="${CC}" \
        CFLAGS="${CFLAGS}" \
        LDFLAGS="${LDFLAGS}"
}

do_install:append() {
    install -d ${D}${bindir}
    install -m 0755 ${USERSPACE_DIR}/axidma_example ${D}${bindir}/
}

# The inherit of module.bbclass will automatically name module packages with
# "kernel-module-" prefix as required by the oe-core build environment.

FILES:${PN} += "${bindir}/axidma_example"
RM_WORK_EXCLUDE += "${PN}"
