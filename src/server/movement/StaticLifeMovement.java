/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server.movement;

import java.awt.Point;
import tools.data.MaplePacketLittleEndianWriter;

/**
 *
 * @author Itzik
 */
public class StaticLifeMovement extends AbstractLifeMovement {

    private Point pixelsPerSecond, offset;
    private short unk, fh;
    private int wui;

    public StaticLifeMovement(int type, Point position, int duration, int newstate, int newfh) {
        super(type, position, duration, newstate, newfh);
    }

    public void setPixelsPerSecond(Point wobble) {
        this.pixelsPerSecond = wobble;
    }

    public void setOffset(Point wobble) {
        this.offset = wobble;
    }

    public void setFh(short fh) {
        this.fh = fh;
    }

    public void setUnk(short unk) {
        this.unk = unk;
    }

    public short getUnk() {
        return unk;
    }

    public void setWui(int wui) {
        this.wui = wui;
    }

    public void defaulted() {
        unk = 0;
        fh = 0;
        pixelsPerSecond = new Point(0, 0);
        offset = new Point(0, 0);
        wui = 0;
    }

    @Override
    public void serialize(MaplePacketLittleEndianWriter lew) {
        lew.write(getType());
        switch (getType()) {
            case 0:
            case 8:
            case 15:
            case 17:
            case 60:
            case 61:
                lew.writePos(getPosition());
                lew.writePos(pixelsPerSecond);
                lew.writeShort(unk);
                if (getType() == 15) {
                    lew.writeShort(fh);
                }
                lew.writePos(offset);
                break;
            case 1:
            case 2:
            case 16:
            case 19:
            case 20:
            case 22:
            case 55:
            case 56:
            case 57:
            case 58:
                lew.writePos(pixelsPerSecond);
                if (getType() == 19 || getType() == 20) {
                    lew.writeShort(fh);
                }
                break;
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 9:
            case 10:
            case 11:
            case 13:
            case 24:
            case 25:
            case 49:
            case 50:
            case 51:
            case 54:
                lew.writePos(getPosition());
                lew.writeShort(unk);
                break;
            case 14:
                lew.writePos(pixelsPerSecond);
                lew.writeShort(fh);
                break;
            case 21:
                lew.writePos(getPosition());
                lew.writePos(pixelsPerSecond);
                break;
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
            case 48:
            case 53:
                break;
            case 59:
                lew.writePos(getPosition());
                lew.writePos(pixelsPerSecond);
                lew.writeShort(unk);
                break;
        }
        if (getType() != 12) {
            lew.write(getNewstate());
            lew.writeShort(getDuration());
//            lew.write(wui);
        } else {
            lew.write(wui);
        }
    }
}
